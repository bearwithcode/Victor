using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Ghost:Enemy
    {
        public Ghost(Game game, Point location) : base(game, location, 8)
        {
        }

        public override void Move(Random random)
        {
            if (HitPoints > 0)
            {
                int chance = random.Next(0, 3);

                if (chance == 2)
                {
                    Direction dir = base.FindPlayerDirection(game.PlayerLocation);
                    location = base.Move(dir, game.Boundaries);
                }

                if (base.Nearby(game.PlayerLocation,30))
                {
                    game.HitPlayer(3,random);                   
                }               
            }
        }
    }
}
