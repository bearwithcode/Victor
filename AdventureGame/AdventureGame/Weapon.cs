using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    abstract class Weapon : Mover
    {
        protected Game game;
        private bool pickedUp;
        public bool PickedUp
        {
            get { return pickedUp; }
            set { pickedUp = value; }
        }

        private Point location;
        public Point Location { get { return location; } }

        public Weapon(Game game, Point location) : base(game, location)
        {
            this.game = game;
            this.location = location;
            pickedUp = false;
        }

        public void PickUpWeapon() { pickedUp = true; }
        public abstract string Name { get; }
        public abstract void Attack(Direction direction, Random random);

        protected bool DamageEnemy(Direction direction, int radius,int damage, Random random)
        {
            Point target = game.PlayerLocation;
            for (int distance = 0; distance < radius; distance++)
            {
                foreach (Enemy enemy in game.Enemies)
                {
                    if (Nearby(enemy.Location, target, radius))
                    {
                        enemy.Hit(damage, random);
                        return true;
                    }
                }
                //target = base.Move(direction, target, game.Boundaries);//there still sth weild in here,could cause problem
            }
            return false;
        }       

        //overload nearby
        public bool Nearby(Point elocation, Point target, int distance)
        {
            if (Math.Abs(elocation.X - target.X) < distance &&
            (Math.Abs(elocation.Y - target.Y) < distance))
            {
                return true;
            }
            else {
                return false;
            }
        }

        
    }
}
