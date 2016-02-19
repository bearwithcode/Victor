using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Mace:Weapon
    {
        public Mace(Game game, Point location) : base(game, location)
        {
        }

        public override string Name { get { return "Mace"; } }
        public override void Attack(Direction direction, Random random)
        {
            Direction c0 = direction,c1 = direction, c2 = direction, c3 = direction;
            switch (direction)
            {
                case Direction.Up:
                    c1 = Direction.Right;
                    c2 = Direction.Down;
                    c3 = Direction.Left;
                    break;
                case Direction.Down:
                    c1 = Direction.Left;
                    c2 = Direction.Up;
                    c3 = Direction.Right;
                    break;
                case Direction.Left:
                    c1 = Direction.Up;
                    c2 = Direction.Right;
                    c3 = Direction.Down;
                    break;
                case Direction.Right:
                    c1 = Direction.Down;
                    c2 = Direction.Left;
                    c3 = Direction.Up;
                    break;
                default: break;
            }

            if (base.DamageEnemy(c0, 60, 6, random) == false)
            {
                if (base.DamageEnemy(c1,60,6,random) == false)
                {
                    if (base.DamageEnemy(c2,60,6,random) == false)
                    {
                        base.DamageEnemy(c3, 60, 6, random);
                    }
                }
            }
        }
    }
}
