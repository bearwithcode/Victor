using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DogRace
{
    public partial class Form1 : Form
    {
        Greyhound[] ghs = new Greyhound[4];
        Players[] players = new Players[3];
        int minbet = 0;
        string curbetname;

        public Form1()
        {
            InitializeComponent();

            ghs[0] = new Greyhound();
            ghs[1] = new Greyhound();
            ghs[2] = new Greyhound();
            ghs[3] = new Greyhound();

            ghs[0].myPBox = dog1;
            ghs[1].myPBox = dog2;
            ghs[2].myPBox = dog3;
            ghs[3].myPBox = dog4;

            Random ranall = new Random();
            ghs[0].Randomizer = ranall;
            ghs[1].Randomizer = ranall;
            ghs[2].Randomizer = ranall;
            ghs[3].Randomizer = ranall;

            players[0] = new Players();
            players[1] = new Players();
            players[2] = new Players();

            players[0].Name = "Joe";
            players[1].Name = "Bob";
            players[2].Name = "Alice";

            players[0].Cash = 50;
            players[1].Cash = 75;
            players[2].Cash = 45;

            players[0].whichPlayer = Joe;
            players[1].whichPlayer = Bob;
            players[2].whichPlayer = Alice;

            players[0].BetDescription = JoeBet;
            players[1].BetDescription = BobBet;
            players[2].BetDescription = AliceBet;

            players[0].MyBet = null;
            players[1].MyBet = null;
            players[2].MyBet = null;
        }

        private void Joe_CheckedChanged(object sender, EventArgs e)
        {
            curbetname = "Joe";
            BettingMan.Text = curbetname;
        }

        private void Bob_CheckedChanged(object sender, EventArgs e)
        {
            curbetname = "Bob";
            BettingMan.Text = curbetname;
        }

        private void Alice_CheckedChanged(object sender, EventArgs e)
        {
            curbetname = "Alice";
            BettingMan.Text = curbetname;
        }

        private void Bet_Click(object sender, EventArgs e)
        {
            int amount = (int)WhoseBucks.Value;
            int numofdog = (int)dogsnum.Value;

            if(minbet == 0)
            {
                minbet = amount;
                MinBucks.Value = minbet;
            }

            if(minbet <= amount)
            {
                switch (curbetname)
                {
                    case "Joe":
                        if (players[0].MyBet != null)
                            players[0].ClearBet();
                        players[0].placeBet(amount, numofdog);
                        players[0].updateLabelinfomation();
                        break;
                    case "Bob":
                        if (players[1].MyBet != null)
                            players[1].ClearBet();
                        players[1].placeBet(amount, numofdog);
                        players[1].updateLabelinfomation();
                        break;
                    case "Alice":
                        if (players[2].MyBet != null)
                            players[2].ClearBet();
                        players[2].placeBet(amount, numofdog);
                        players[2].updateLabelinfomation();
                        break;
                }
            }
            else
            {
                MessageBox.Show("can't small than mininum");
            }
        }

        private void StartRace_Click(object sender, EventArgs e)
        {
            if (players[0].MyBet == null || players[1].MyBet == null || players[2].MyBet == null) {
                MessageBox.Show("all players need to bet mininum for game");
            }
            else
            {
                Bet.Enabled = false;

                bool h1 = false, h2 = false, h3 =false, h4 = false;
               
                int winid = 0;

                while(true)
                {
                    h1 = ghs[0].run();
                    h2 = ghs[1].run();
                    h3 = ghs[2].run();
                    h4 = ghs[3].run();

                    if (h1 == true)
                    {
                        winid = 1;
                        break;
                    }
                    if (h2 == true)
                    {
                        winid = 2;
                        break;
                    }
                    if (h3 == true) {
                        winid = 3;
                        break;
                    }
                    if (h4 == true)
                    {
                        winid = 4;
                        break;
                    }
                }


                MessageBox.Show("we have a winner -  dog " + winid);
                
                for(int i = 0;i < players.Length;i++)
                {
                    players[i].Collect(winid);
                    players[i].updateLabelinfomation();
                }

                for(int i = 0;i < ghs.Length;i++)
                {
                    ghs[i].TakeStartingPosition();
                }

                Bet.Enabled = true;
            }
            
        }
    }
}
