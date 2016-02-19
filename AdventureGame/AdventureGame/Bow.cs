using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Bow:Weapon
    {
        public Bow(Game game, Point location) : base(game, location)
        {
        }

        public override string Name { get { return "Bow"; } }
        public override void Attack(Direction direction, Random random)
        {
            base.DamageEnemy(direction, 90, 1, random);
        }
    }
}
