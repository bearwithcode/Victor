using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class Bat:Enemy
    {
        public Bat(Game game, Point location) : base(game, location, 6)
        {
        }

        public override void Move(Random random)
        {
            if (HitPoints > 0)
            {
                int chance = random.Next(0, 1);

                if (chance == 0)
                {
                    int index = random.Next(0, 4);
                    Direction rdir = (Direction)index;
                    location = base.Move(rdir, game.Boundaries);
                }
                else
                {
                    Direction dir = base.FindPlayerDirection(game.PlayerLocation);
                    location = base.Move(dir, game.Boundaries);
                }

                if (base.Nearby(game.PlayerLocation, 30))
                {
                    game.HitPlayer(2,random);                   
                }
            }         
        }
    }
}
