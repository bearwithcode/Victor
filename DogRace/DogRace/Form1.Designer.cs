namespace DogRace
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.label5 = new System.Windows.Forms.Label();
            this.StartRace = new System.Windows.Forms.Button();
            this.dogsnum = new System.Windows.Forms.NumericUpDown();
            this.AliceBet = new System.Windows.Forms.TextBox();
            this.BobBet = new System.Windows.Forms.TextBox();
            this.JoeBet = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.WhoseBucks = new System.Windows.Forms.NumericUpDown();
            this.Bet = new System.Windows.Forms.Button();
            this.BettingMan = new System.Windows.Forms.Label();
            this.MinBucks = new System.Windows.Forms.NumericUpDown();
            this.label1 = new System.Windows.Forms.Label();
            this.Alice = new System.Windows.Forms.RadioButton();
            this.Bob = new System.Windows.Forms.RadioButton();
            this.Joe = new System.Windows.Forms.RadioButton();
            this.dog4 = new System.Windows.Forms.PictureBox();
            this.dog3 = new System.Windows.Forms.PictureBox();
            this.dog2 = new System.Windows.Forms.PictureBox();
            this.dog1 = new System.Windows.Forms.PictureBox();
            this.racetrack = new System.Windows.Forms.PictureBox();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dogsnum)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.WhoseBucks)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.MinBucks)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.racetrack)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.StartRace);
            this.groupBox1.Controls.Add(this.dogsnum);
            this.groupBox1.Controls.Add(this.AliceBet);
            this.groupBox1.Controls.Add(this.BobBet);
            this.groupBox1.Controls.Add(this.JoeBet);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.WhoseBucks);
            this.groupBox1.Controls.Add(this.Bet);
            this.groupBox1.Controls.Add(this.BettingMan);
            this.groupBox1.Controls.Add(this.MinBucks);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.Alice);
            this.groupBox1.Controls.Add(this.Bob);
            this.groupBox1.Controls.Add(this.Joe);
            this.groupBox1.Location = new System.Drawing.Point(0, 415);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(1382, 244);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Betting Parlor";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label5.Location = new System.Drawing.Point(371, 51);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(77, 25);
            this.label5.TabIndex = 15;
            this.label5.Text = "bucks";
            // 
            // StartRace
            // 
            this.StartRace.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.StartRace.Location = new System.Drawing.Point(972, 171);
            this.StartRace.Name = "StartRace";
            this.StartRace.Size = new System.Drawing.Size(112, 73);
            this.StartRace.TabIndex = 14;
            this.StartRace.Text = "Race!";
            this.StartRace.UseVisualStyleBackColor = true;
            this.StartRace.Click += new System.EventHandler(this.StartRace_Click);
            // 
            // dogsnum
            // 
            this.dogsnum.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.dogsnum.Location = new System.Drawing.Point(1117, 91);
            this.dogsnum.Maximum = new decimal(new int[] {
            4,
            0,
            0,
            0});
            this.dogsnum.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.dogsnum.Name = "dogsnum";
            this.dogsnum.Size = new System.Drawing.Size(120, 36);
            this.dogsnum.TabIndex = 13;
            this.dogsnum.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // AliceBet
            // 
            this.AliceBet.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.AliceBet.Location = new System.Drawing.Point(440, 194);
            this.AliceBet.Name = "AliceBet";
            this.AliceBet.ReadOnly = true;
            this.AliceBet.Size = new System.Drawing.Size(321, 36);
            this.AliceBet.TabIndex = 12;
            // 
            // BobBet
            // 
            this.BobBet.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.BobBet.Location = new System.Drawing.Point(440, 141);
            this.BobBet.Name = "BobBet";
            this.BobBet.ReadOnly = true;
            this.BobBet.Size = new System.Drawing.Size(321, 36);
            this.BobBet.TabIndex = 11;
            // 
            // JoeBet
            // 
            this.JoeBet.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.JoeBet.Location = new System.Drawing.Point(440, 91);
            this.JoeBet.Name = "JoeBet";
            this.JoeBet.ReadOnly = true;
            this.JoeBet.Size = new System.Drawing.Size(321, 36);
            this.JoeBet.TabIndex = 10;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label4.Location = new System.Drawing.Point(478, 55);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(64, 25);
            this.label4.TabIndex = 9;
            this.label4.Text = "Bets";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label3.Location = new System.Drawing.Point(1112, 47);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(272, 25);
            this.label3.TabIndex = 8;
            this.label3.Text = "bucks on dog number ";
            // 
            // WhoseBucks
            // 
            this.WhoseBucks.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.WhoseBucks.Location = new System.Drawing.Point(972, 47);
            this.WhoseBucks.Maximum = new decimal(new int[] {
            15,
            0,
            0,
            0});
            this.WhoseBucks.Minimum = new decimal(new int[] {
            5,
            0,
            0,
            0});
            this.WhoseBucks.Name = "WhoseBucks";
            this.WhoseBucks.Size = new System.Drawing.Size(120, 36);
            this.WhoseBucks.TabIndex = 7;
            this.WhoseBucks.Value = new decimal(new int[] {
            5,
            0,
            0,
            0});
            // 
            // Bet
            // 
            this.Bet.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Bet.Location = new System.Drawing.Point(840, 51);
            this.Bet.Name = "Bet";
            this.Bet.Size = new System.Drawing.Size(126, 33);
            this.Bet.TabIndex = 6;
            this.Bet.Text = "Bet\r\n";
            this.Bet.UseVisualStyleBackColor = true;
            this.Bet.Click += new System.EventHandler(this.Bet_Click);
            // 
            // BettingMan
            // 
            this.BettingMan.AutoSize = true;
            this.BettingMan.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.BettingMan.Location = new System.Drawing.Point(761, 55);
            this.BettingMan.Name = "BettingMan";
            this.BettingMan.Size = new System.Drawing.Size(0, 25);
            this.BettingMan.TabIndex = 5;
            // 
            // MinBucks
            // 
            this.MinBucks.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.MinBucks.Location = new System.Drawing.Point(184, 40);
            this.MinBucks.Name = "MinBucks";
            this.MinBucks.ReadOnly = true;
            this.MinBucks.Size = new System.Drawing.Size(167, 36);
            this.MinBucks.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(23, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(155, 25);
            this.label1.TabIndex = 3;
            this.label1.Text = "Mininum Bet";
            // 
            // Alice
            // 
            this.Alice.AutoSize = true;
            this.Alice.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Alice.Location = new System.Drawing.Point(26, 201);
            this.Alice.Name = "Alice";
            this.Alice.Size = new System.Drawing.Size(98, 29);
            this.Alice.TabIndex = 2;
            this.Alice.TabStop = true;
            this.Alice.Text = "Alice";
            this.Alice.UseVisualStyleBackColor = true;
            this.Alice.CheckedChanged += new System.EventHandler(this.Alice_CheckedChanged);
            // 
            // Bob
            // 
            this.Bob.AutoSize = true;
            this.Bob.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Bob.Location = new System.Drawing.Point(26, 148);
            this.Bob.Name = "Bob";
            this.Bob.Size = new System.Drawing.Size(72, 29);
            this.Bob.TabIndex = 1;
            this.Bob.TabStop = true;
            this.Bob.Text = "Bob";
            this.Bob.UseVisualStyleBackColor = true;
            this.Bob.CheckedChanged += new System.EventHandler(this.Bob_CheckedChanged);
            // 
            // Joe
            // 
            this.Joe.AutoSize = true;
            this.Joe.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Joe.Location = new System.Drawing.Point(26, 91);
            this.Joe.Name = "Joe";
            this.Joe.Size = new System.Drawing.Size(72, 29);
            this.Joe.TabIndex = 0;
            this.Joe.TabStop = true;
            this.Joe.Text = "Joe";
            this.Joe.UseVisualStyleBackColor = true;
            this.Joe.CheckedChanged += new System.EventHandler(this.Joe_CheckedChanged);
            // 
            // dog4
            // 
            this.dog4.Image = global::DogRace.Properties.Resources.dog;
            this.dog4.Location = new System.Drawing.Point(72, 328);
            this.dog4.Name = "dog4";
            this.dog4.Size = new System.Drawing.Size(133, 67);
            this.dog4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.dog4.TabIndex = 5;
            this.dog4.TabStop = false;
            // 
            // dog3
            // 
            this.dog3.Image = global::DogRace.Properties.Resources.dog;
            this.dog3.Location = new System.Drawing.Point(72, 218);
            this.dog3.Name = "dog3";
            this.dog3.Size = new System.Drawing.Size(133, 67);
            this.dog3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.dog3.TabIndex = 4;
            this.dog3.TabStop = false;
            // 
            // dog2
            // 
            this.dog2.Image = global::DogRace.Properties.Resources.dog;
            this.dog2.Location = new System.Drawing.Point(72, 104);
            this.dog2.Name = "dog2";
            this.dog2.Size = new System.Drawing.Size(133, 67);
            this.dog2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.dog2.TabIndex = 3;
            this.dog2.TabStop = false;
            // 
            // dog1
            // 
            this.dog1.Image = global::DogRace.Properties.Resources.dog;
            this.dog1.Location = new System.Drawing.Point(72, 12);
            this.dog1.Name = "dog1";
            this.dog1.Size = new System.Drawing.Size(133, 67);
            this.dog1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.dog1.TabIndex = 2;
            this.dog1.TabStop = false;
            // 
            // racetrack
            // 
            this.racetrack.Image = global::DogRace.Properties.Resources.racetrack;
            this.racetrack.Location = new System.Drawing.Point(0, 3);
            this.racetrack.Name = "racetrack";
            this.racetrack.Size = new System.Drawing.Size(1382, 406);
            this.racetrack.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.racetrack.TabIndex = 0;
            this.racetrack.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1394, 671);
            this.Controls.Add(this.dog4);
            this.Controls.Add(this.dog3);
            this.Controls.Add(this.dog2);
            this.Controls.Add(this.dog1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.racetrack);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dogsnum)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.WhoseBucks)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.MinBucks)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dog1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.racetrack)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox racetrack;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label BettingMan;
        private System.Windows.Forms.NumericUpDown MinBucks;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.RadioButton Alice;
        private System.Windows.Forms.RadioButton Bob;
        private System.Windows.Forms.RadioButton Joe;
        private System.Windows.Forms.NumericUpDown dogsnum;
        private System.Windows.Forms.TextBox AliceBet;
        private System.Windows.Forms.TextBox BobBet;
        private System.Windows.Forms.TextBox JoeBet;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.NumericUpDown WhoseBucks;
        private System.Windows.Forms.Button Bet;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button StartRace;
        private System.Windows.Forms.PictureBox dog1;
        private System.Windows.Forms.PictureBox dog2;
        private System.Windows.Forms.PictureBox dog3;
        private System.Windows.Forms.PictureBox dog4;
    }
}

