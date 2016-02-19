using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Player : Mover
    {
        private Weapon equippedWeapon;
        private int hitPoints;
        public int HitPoints { get { return hitPoints; } }
        private List<Weapon> inventory = new List<Weapon>();
        public List<string> Weapons
        {
            get
            {
                List<string> names = new List<string>();
                foreach (Weapon weapon in inventory)
                    names.Add(weapon.Name);
                return names;
            }
        }

        public Player(Game game, Point location)
        : base(game, location) {
            hitPoints = 10;
        }

        public void Hit(int maxDamage, Random random)
        {
            hitPoints -= random.Next(1, maxDamage);
        }

        public void IncreaseHealth(int health, Random random)
        {
            hitPoints += random.Next(1, health);
        }

        public void Equip(string weaponName)
        {
            foreach (Weapon weapon in inventory)
            {
                if (weapon.Name == weaponName)
                    equippedWeapon = weapon;
            }
        }

        public void Attack(Direction direction, Random random)
        {           
            if (equippedWeapon != null)
            {
                equippedWeapon.Attack(direction, random);
                if (equippedWeapon is IPotion)
                {
                    if (equippedWeapon.Name.Equals("Blue Potion"))
                    {
                        IncreaseHealth(5,random);
                        equippedWeapon.Attack(direction,random);
                    }
                    else if (equippedWeapon.Name.Equals("Red Potion"))
                    {
                        IncreaseHealth(10,random);
                        equippedWeapon.Attack(direction,random);
                    }
                    inventory.Remove(equippedWeapon);
                }
            }
        }

        public void Move(Direction direction)
        {
            base.location = Move(direction, game.Boundaries);
            if (!game.WeaponInRoom.PickedUp)
            {
                if (Nearby(game.WeaponInRoom.Location, 30) == true)
                {
                    inventory.Add(game.WeaponInRoom);
                    if (inventory.Count == 0)
                    {
                        Equip(game.WeaponInRoom.Name);
                    }
                    
                    game.WeaponInRoom.PickedUp = true;
                }
            }
        }
    }
}
