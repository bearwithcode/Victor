using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DogRace
{
    class Greyhound
    {
        public int StartingPosition = 72;
        public int RaceTracklength = 1249;
        public PictureBox myPBox;
        public Random Randomizer;

        public bool run() {
            bool finish = false;
            
            int step = Randomizer.Next(1, 5) * 10;
            Point p = myPBox.Location;
            p.X += step;
            myPBox.Location = p;

            if (p.X >= RaceTracklength - 325) {
                finish = true;
            }

            Thread.Sleep(100);
            return finish;
        }

        public void TakeStartingPosition()
        {
            myPBox.Location = new Point(StartingPosition, myPBox.Location.Y);
        }
    }
}
