using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Sword:Weapon
    {
        public Sword(Game game, Point location) : base(game, location)
        {
        }

        public override string Name { get { return "Sword"; } }
        public override void Attack(Direction direction, Random random)
        {
            Direction oringinal = direction;
            Direction cw = direction, ccw = direction;
            switch (direction)
            {
                case Direction.Up:
                    cw = Direction.Right;
                    ccw = Direction.Left;
                    break;
                case Direction.Down:
                    cw = Direction.Left;
                    ccw = Direction.Right;
                    break;
                case Direction.Left:
                    cw = Direction.Up;
                    ccw = Direction.Down;
                    break;
                case Direction.Right:
                    cw = Direction.Down;
                    cw = Direction.Up;
                    break;
                default: break;
            }
            if (base.DamageEnemy(oringinal, 30, 3, random) == false)
            {
                if (base.DamageEnemy(cw,30,3,random) == false)
                {
                    base.DamageEnemy(ccw, 30, 3, random);
                }
            }
        }
    }
}
