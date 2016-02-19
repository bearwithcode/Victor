using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DogRace
{
    class Players
    {
        public string Name;
        public Bet MyBet;
        public int Cash;

        public RadioButton whichPlayer;
        public TextBox BetDescription;

        public void updateLabelinfomation()
        {
            whichPlayer.Text = Name + " has " + Cash + " bucks";
            if (MyBet == null)
                BetDescription.Text = Name + " hasn't place a bet yet";
            else
                BetDescription.Text = MyBet.getDescription();
        }

        public void ClearBet() {
            MyBet = null;
        }

        public bool placeBet(int Amount, int Dog) {
            if(Amount < Cash)
            {
                MyBet = new Bet();
                MyBet.Better = this;
                MyBet.Amount = Amount;
                MyBet.Dog = Dog;
                return true;
            }
            else
            {
                return false;
            }
        }

        public void Collect(int Winner) {
            Cash += MyBet.PayOut(Winner);
        }
    }
}
