using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AdventureGame
{
    public partial class Form1 : Form
    {
        private Game game;
        private Random random = new Random();

        public Form1()
        {
            InitializeComponent();
        }

        private void Mup_Click(object sender, EventArgs e)
        {
            game.Move(Direction.Up, random);
            UpdateCharacters();
        }

        private void Mleft_Click(object sender, EventArgs e)
        {
            game.Move(Direction.Left, random);
            UpdateCharacters();
        }

        private void Mdown_Click(object sender, EventArgs e)
        {
            game.Move(Direction.Down, random);
            UpdateCharacters();
        }

        private void Mright_Click(object sender, EventArgs e)
        {
            game.Move(Direction.Right, random);
            UpdateCharacters();
        }

        private void Aup_Click(object sender, EventArgs e)
        {
            game.Attack(Direction.Up, random);
            UpdateCharacters();
        }

        private void Aleft_Click(object sender, EventArgs e)
        {
            game.Attack(Direction.Left, random);
            UpdateCharacters();
        }

        private void Aright_Click(object sender, EventArgs e)
        {
            game.Attack(Direction.Right, random);
            UpdateCharacters();
        }

        private void Adown_Click(object sender, EventArgs e)
        {
            game.Attack(Direction.Down, random);
            UpdateCharacters();
        }

        private void itemSord_Click(object sender, EventArgs e)
        {
            game.CheckPlayerInventory("Sord");
            game.Equip("Sord");
            itemSord.BackColor = Color.GreenYellow;

            itemBow.BackColor = Color.FromArgb(241, 223, 160);
            itemMace.BackColor = Color.FromArgb(241, 223, 160);
            itemBP.BackColor = Color.FromArgb(241, 223, 160);
            itemRP.BackColor = Color.FromArgb(241, 223, 160);
        }

        private void itemBow_Click(object sender, EventArgs e)
        {
            if (game.CheckPlayerInventory("Bow"))
            {
                game.Equip("Bow");
                itemBow.BackColor = Color.GreenYellow;

                itemSord.BackColor = Color.FromArgb(241, 223, 160);
                itemMace.BackColor = Color.FromArgb(241, 223, 160);
                itemBP.BackColor = Color.FromArgb(241, 223, 160);
                itemRP.BackColor = Color.FromArgb(241, 223, 160);
            }
     
        }

        private void itemMace_Click(object sender, EventArgs e)
        {
            if (game.CheckPlayerInventory("Mace"))
            {
                game.Equip("Mace");
                itemMace.BackColor = Color.GreenYellow;

                itemSord.BackColor = Color.FromArgb(241, 223, 160);
                itemBow.BackColor = Color.FromArgb(241, 223, 160);
                itemBP.BackColor = Color.FromArgb(241, 223, 160);
                itemRP.BackColor = Color.FromArgb(241, 223, 160);
            }
                    
        }

        private void itemRP_Click(object sender, EventArgs e)
        {
            if (game.CheckPlayerInventory("Red Potion"))
            {
                game.Equip("Red Potion");
                itemRP.BackColor = Color.GreenYellow;

                itemSord.BackColor = Color.FromArgb(241, 223, 160);
                itemBow.BackColor = Color.FromArgb(241, 223, 160);
                itemBP.BackColor = Color.FromArgb(241, 223, 160);
                itemMace.BackColor = Color.FromArgb(241, 223, 160);
            }
            else
            {
                MessageBox.Show("potion empty");
            }
        }

        private void itemBP_Click(object sender, EventArgs e)
        {
            if (game.CheckPlayerInventory("Blue Potion"))
            {
                game.Equip("Blue Potion");
                itemBP.BackColor = Color.GreenYellow;

                itemSord.BackColor = Color.FromArgb(241, 223, 160);
                itemBow.BackColor = Color.FromArgb(241, 223, 160);
                itemRP.BackColor = Color.FromArgb(241, 223, 160);
                itemMace.BackColor = Color.FromArgb(241, 223, 160);
            }
            else
            {
                MessageBox.Show("potion empty");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            game = new Game(new Rectangle(110,83,680,305));
            game.NewLevel(random);
            UpdateCharacters();
        }

        public void UpdateCharacters()
        {
            Playerimg.Location = game.PlayerLocation;
            pHP.Text = game.PlayerHitPoints.ToString();

            Playerimg.Visible = true;
           
            Batimg.Visible = false;
            Ghostimg.Visible = false;
            Ghoulimg.Visible = false;
            int enemiesshown = 0;

            Swordimg.Visible = false;
            Bowimg.Visible = false;
            Redpotionimg.Visible = false;
            Bluepotionimg.Visible = false;
            Maseimg.Visible = false;

            Control weaponControl = null;
            switch (game.WeaponInRoom.Name)
            {
                case "Sword":
                    weaponControl = Swordimg;
                    break;
                case "Bow":
                    weaponControl = Bowimg;
                    break;
                case "Mace":
                    weaponControl = Maseimg;
                    break;
                case "Blue Potion":
                    weaponControl = Bluepotionimg;
                    break;
                case "Red Potion":
                    weaponControl = Redpotionimg;
                    break;
                default:break;
            }

            weaponControl.Visible = true;
            weaponControl.Location = game.WeaponInRoom.Location;

            foreach (Enemy enemy in game.Enemies)
            {
                if (enemy is Bat)
                {
                    Batimg.Location = enemy.Location;
                    bHP.Text = enemy.HitPoints.ToString();
                    if (enemy.HitPoints > 0)
                    {
                        Batimg.Visible = true;
                        enemiesshown ++;
                    }
                }
               else if (enemy is Ghost)
               {
                    Ghostimg.Location = enemy.Location;
                    GstHP.Text = enemy.HitPoints.ToString();
                   if (enemy.HitPoints > 0)
                   {
                       Ghostimg.Visible = true;
                       enemiesshown ++;
                   }
               }
               else if (enemy is Ghoul)
               {
                   Ghoulimg.Location = enemy.Location;
                   oulHP.Text = enemy.HitPoints.ToString();
                   if (enemy.HitPoints > 0)
                   {
                       Ghoulimg.Visible = true;
                       enemiesshown ++;
                   }
               }
            }           

            string[] weaponnames = {"Bow","Sword","Mace", "Blue Potion", "Red Potion"};
            foreach (string wname in weaponnames)
            {
                if (game.CheckPlayerInventory(wname))
                {
                    switch (wname)
                    {
                        case "Sword":
                            itemSord.Visible = true;
                            break;
                        case "Bow":
                            itemBow.Visible = true;
                            break;
                        case "Mace":
                            itemMace.Visible = true;
                            break;
                        case "Blue Potion":
                            itemBP.Visible = true;
                            break;
                        case "Red Potion":
                            itemRP.Visible = true;
                            break;
                        default:break;
                    }
                }
            }           
            if (game.WeaponInRoom.PickedUp)
            {
                weaponControl.Visible = false;
            }
            else {
                weaponControl.Visible = true;
            }
            if (game.PlayerHitPoints <= 0)
            {
                MessageBox.Show("You died");
                Application.Exit();
            }
            if (enemiesshown < 1)
            {
                MessageBox.Show("You have defeated the enemies on this level");
                game.NewLevel(random);
                UpdateCharacters();
            }
        }
        
    }
}
