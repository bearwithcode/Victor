using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DogRace
{
    class Bet
    {
        public int Amount;
        public int Dog;
        public Players Better;

        public string getDescription()
        {
            string betdis;

            betdis = Better.Name + " bets " + Amount + " On dog " + Dog;
            
            return betdis;
        }

        public int PayOut(int Winner) {
            if (Winner == Dog)
            {
                return Amount * 2;
            }
            else {
                return -Amount;
            }
        }
    }
}
