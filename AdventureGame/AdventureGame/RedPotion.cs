﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventureGame
{
    class RedPotion:Weapon,IPotion
    {
        public RedPotion(Game game, Point location) : base(game, location)
        {
            Used = false;
        }

        public override string Name { get { return "Red Potion"; } }
        public override void Attack(Direction direction, Random random)
        {
            Used = true;
        }

        public bool Used { get; set; }
    }
}
