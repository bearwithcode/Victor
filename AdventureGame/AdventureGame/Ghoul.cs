using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Ghoul:Enemy
    {
        public Ghoul(Game game, Point location) : base(game, location, 10)
        {
        }

        public override void Move(Random random)
        {
            if (HitPoints > 0)
            {
                int chance = random.Next(0, 3);

                if (chance == 0 || chance == 1)
                {
                    Direction dir = base.FindPlayerDirection(game.PlayerLocation);
                    location = base.Move(dir, game.Boundaries);
                }

                if (base.Nearby(game.PlayerLocation, 30))
                {
                    game.HitPlayer(4,random);
                }
            }
        }
    }
}
