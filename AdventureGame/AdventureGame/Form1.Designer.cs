namespace AdventureGame
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
            this.Mdown = new System.Windows.Forms.Button();
            this.Mright = new System.Windows.Forms.Button();
            this.Mleft = new System.Windows.Forms.Button();
            this.Mup = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.Adown = new System.Windows.Forms.Button();
            this.Aright = new System.Windows.Forms.Button();
            this.Aleft = new System.Windows.Forms.Button();
            this.Aup = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.pHP = new System.Windows.Forms.Label();
            this.bHP = new System.Windows.Forms.Label();
            this.GstHP = new System.Windows.Forms.Label();
            this.oulHP = new System.Windows.Forms.Label();
            this.Redpotionimg = new System.Windows.Forms.PictureBox();
            this.Bluepotionimg = new System.Windows.Forms.PictureBox();
            this.Bowimg = new System.Windows.Forms.PictureBox();
            this.Maseimg = new System.Windows.Forms.PictureBox();
            this.Ghostimg = new System.Windows.Forms.PictureBox();
            this.Ghoulimg = new System.Windows.Forms.PictureBox();
            this.Batimg = new System.Windows.Forms.PictureBox();
            this.Swordimg = new System.Windows.Forms.PictureBox();
            this.Playerimg = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.itemSord = new System.Windows.Forms.PictureBox();
            this.itemBow = new System.Windows.Forms.PictureBox();
            this.itemMace = new System.Windows.Forms.PictureBox();
            this.itemRP = new System.Windows.Forms.PictureBox();
            this.itemBP = new System.Windows.Forms.PictureBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Redpotionimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Bluepotionimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Bowimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Maseimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Ghostimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Ghoulimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Batimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Swordimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Playerimg)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemSord)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemBow)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemMace)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemRP)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemBP)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.Mdown);
            this.groupBox1.Controls.Add(this.Mright);
            this.groupBox1.Controls.Add(this.Mleft);
            this.groupBox1.Controls.Add(this.Mup);
            this.groupBox1.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.groupBox1.Location = new System.Drawing.Point(1228, 7);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(329, 214);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Move";
            // 
            // Mdown
            // 
            this.Mdown.Location = new System.Drawing.Point(116, 149);
            this.Mdown.Name = "Mdown";
            this.Mdown.Size = new System.Drawing.Size(107, 37);
            this.Mdown.TabIndex = 3;
            this.Mdown.Text = "Down\r\n";
            this.Mdown.UseVisualStyleBackColor = true;
            this.Mdown.Click += new System.EventHandler(this.Mdown_Click);
            // 
            // Mright
            // 
            this.Mright.Location = new System.Drawing.Point(222, 96);
            this.Mright.Name = "Mright";
            this.Mright.Size = new System.Drawing.Size(107, 37);
            this.Mright.TabIndex = 2;
            this.Mright.Text = "Right";
            this.Mright.UseVisualStyleBackColor = true;
            this.Mright.Click += new System.EventHandler(this.Mright_Click);
            // 
            // Mleft
            // 
            this.Mleft.Location = new System.Drawing.Point(6, 96);
            this.Mleft.Name = "Mleft";
            this.Mleft.Size = new System.Drawing.Size(107, 37);
            this.Mleft.TabIndex = 1;
            this.Mleft.Text = "Left\r\n";
            this.Mleft.UseVisualStyleBackColor = true;
            this.Mleft.Click += new System.EventHandler(this.Mleft_Click);
            // 
            // Mup
            // 
            this.Mup.Location = new System.Drawing.Point(116, 44);
            this.Mup.Name = "Mup";
            this.Mup.Size = new System.Drawing.Size(107, 37);
            this.Mup.TabIndex = 0;
            this.Mup.Text = "Up";
            this.Mup.UseVisualStyleBackColor = true;
            this.Mup.Click += new System.EventHandler(this.Mup_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.Adown);
            this.groupBox2.Controls.Add(this.Aright);
            this.groupBox2.Controls.Add(this.Aleft);
            this.groupBox2.Controls.Add(this.Aup);
            this.groupBox2.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.groupBox2.Location = new System.Drawing.Point(1225, 227);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(348, 214);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Attack";
            // 
            // Adown
            // 
            this.Adown.Location = new System.Drawing.Point(122, 160);
            this.Adown.Name = "Adown";
            this.Adown.Size = new System.Drawing.Size(104, 33);
            this.Adown.TabIndex = 3;
            this.Adown.Text = "Down";
            this.Adown.UseVisualStyleBackColor = true;
            this.Adown.Click += new System.EventHandler(this.Adown_Click);
            // 
            // Aright
            // 
            this.Aright.Location = new System.Drawing.Point(235, 111);
            this.Aright.Name = "Aright";
            this.Aright.Size = new System.Drawing.Size(107, 33);
            this.Aright.TabIndex = 2;
            this.Aright.Text = "Right\r\n";
            this.Aright.UseVisualStyleBackColor = true;
            this.Aright.Click += new System.EventHandler(this.Aright_Click);
            // 
            // Aleft
            // 
            this.Aleft.Location = new System.Drawing.Point(9, 111);
            this.Aleft.Name = "Aleft";
            this.Aleft.Size = new System.Drawing.Size(107, 33);
            this.Aleft.TabIndex = 1;
            this.Aleft.Text = "Left";
            this.Aleft.UseVisualStyleBackColor = true;
            this.Aleft.Click += new System.EventHandler(this.Aleft_Click);
            // 
            // Aup
            // 
            this.Aup.Location = new System.Drawing.Point(119, 55);
            this.Aup.Name = "Aup";
            this.Aup.Size = new System.Drawing.Size(107, 33);
            this.Aup.TabIndex = 0;
            this.Aup.Text = "Up\r\n";
            this.Aup.UseVisualStyleBackColor = true;
            this.Aup.Click += new System.EventHandler(this.Aup_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(3, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(90, 25);
            this.label1.TabIndex = 3;
            this.label1.Text = "Player";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label2.Location = new System.Drawing.Point(3, 78);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(51, 25);
            this.label2.TabIndex = 4;
            this.label2.Text = "Bat";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label3.Location = new System.Drawing.Point(3, 170);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(77, 25);
            this.label3.TabIndex = 5;
            this.label3.Text = "Ghost";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label4.Location = new System.Drawing.Point(3, 260);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(77, 25);
            this.label4.TabIndex = 6;
            this.label4.Text = "Ghoul";
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.label4, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.label2, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.label3, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.pHP, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.bHP, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.GstHP, 1, 2);
            this.tableLayoutPanel1.Controls.Add(this.oulHP, 1, 3);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(1234, 466);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 4;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 45.91837F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 54.08163F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 90F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(323, 311);
            this.tableLayoutPanel1.TabIndex = 7;
            // 
            // pHP
            // 
            this.pHP.AutoSize = true;
            this.pHP.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.pHP.Location = new System.Drawing.Point(164, 0);
            this.pHP.Name = "pHP";
            this.pHP.Size = new System.Drawing.Size(0, 25);
            this.pHP.TabIndex = 7;
            // 
            // bHP
            // 
            this.bHP.AutoSize = true;
            this.bHP.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.bHP.Location = new System.Drawing.Point(164, 78);
            this.bHP.Name = "bHP";
            this.bHP.Size = new System.Drawing.Size(0, 25);
            this.bHP.TabIndex = 8;
            // 
            // GstHP
            // 
            this.GstHP.AutoSize = true;
            this.GstHP.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.GstHP.Location = new System.Drawing.Point(164, 170);
            this.GstHP.Name = "GstHP";
            this.GstHP.Size = new System.Drawing.Size(0, 25);
            this.GstHP.TabIndex = 9;
            // 
            // oulHP
            // 
            this.oulHP.AutoSize = true;
            this.oulHP.Font = new System.Drawing.Font("SimSun", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.oulHP.Location = new System.Drawing.Point(164, 260);
            this.oulHP.Name = "oulHP";
            this.oulHP.Size = new System.Drawing.Size(0, 25);
            this.oulHP.TabIndex = 10;
            // 
            // Redpotionimg
            // 
            this.Redpotionimg.BackColor = System.Drawing.Color.DarkGray;
            this.Redpotionimg.Image = global::AdventureGame.Properties.Resources.potion_red;
            this.Redpotionimg.Location = new System.Drawing.Point(431, 86);
            this.Redpotionimg.Name = "Redpotionimg";
            this.Redpotionimg.Size = new System.Drawing.Size(30, 30);
            this.Redpotionimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Redpotionimg.TabIndex = 16;
            this.Redpotionimg.TabStop = false;
            this.Redpotionimg.Visible = false;
            // 
            // Bluepotionimg
            // 
            this.Bluepotionimg.BackColor = System.Drawing.Color.DarkGray;
            this.Bluepotionimg.Image = global::AdventureGame.Properties.Resources.potion_blue;
            this.Bluepotionimg.Location = new System.Drawing.Point(395, 86);
            this.Bluepotionimg.Name = "Bluepotionimg";
            this.Bluepotionimg.Size = new System.Drawing.Size(30, 30);
            this.Bluepotionimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Bluepotionimg.TabIndex = 15;
            this.Bluepotionimg.TabStop = false;
            this.Bluepotionimg.Visible = false;
            // 
            // Bowimg
            // 
            this.Bowimg.BackColor = System.Drawing.Color.DarkGray;
            this.Bowimg.Image = global::AdventureGame.Properties.Resources.bow;
            this.Bowimg.Location = new System.Drawing.Point(359, 86);
            this.Bowimg.Name = "Bowimg";
            this.Bowimg.Size = new System.Drawing.Size(30, 30);
            this.Bowimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Bowimg.TabIndex = 14;
            this.Bowimg.TabStop = false;
            this.Bowimg.Visible = false;
            // 
            // Maseimg
            // 
            this.Maseimg.BackColor = System.Drawing.Color.DarkGray;
            this.Maseimg.Image = global::AdventureGame.Properties.Resources.mace;
            this.Maseimg.Location = new System.Drawing.Point(287, 86);
            this.Maseimg.Name = "Maseimg";
            this.Maseimg.Size = new System.Drawing.Size(30, 30);
            this.Maseimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Maseimg.TabIndex = 13;
            this.Maseimg.TabStop = false;
            this.Maseimg.Visible = false;
            // 
            // Ghostimg
            // 
            this.Ghostimg.BackColor = System.Drawing.Color.DarkGray;
            this.Ghostimg.Image = global::AdventureGame.Properties.Resources.ghost;
            this.Ghostimg.Location = new System.Drawing.Point(251, 86);
            this.Ghostimg.Name = "Ghostimg";
            this.Ghostimg.Size = new System.Drawing.Size(30, 30);
            this.Ghostimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Ghostimg.TabIndex = 12;
            this.Ghostimg.TabStop = false;
            this.Ghostimg.Visible = false;
            // 
            // Ghoulimg
            // 
            this.Ghoulimg.BackColor = System.Drawing.Color.DarkGray;
            this.Ghoulimg.Image = global::AdventureGame.Properties.Resources.ghoul;
            this.Ghoulimg.Location = new System.Drawing.Point(215, 86);
            this.Ghoulimg.Name = "Ghoulimg";
            this.Ghoulimg.Size = new System.Drawing.Size(30, 30);
            this.Ghoulimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Ghoulimg.TabIndex = 11;
            this.Ghoulimg.TabStop = false;
            this.Ghoulimg.Visible = false;
            // 
            // Batimg
            // 
            this.Batimg.BackColor = System.Drawing.Color.DarkGray;
            this.Batimg.Image = global::AdventureGame.Properties.Resources.bat;
            this.Batimg.Location = new System.Drawing.Point(179, 86);
            this.Batimg.Name = "Batimg";
            this.Batimg.Size = new System.Drawing.Size(30, 30);
            this.Batimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Batimg.TabIndex = 10;
            this.Batimg.TabStop = false;
            this.Batimg.Visible = false;
            // 
            // Swordimg
            // 
            this.Swordimg.BackColor = System.Drawing.Color.DarkGray;
            this.Swordimg.Image = global::AdventureGame.Properties.Resources.sword;
            this.Swordimg.Location = new System.Drawing.Point(323, 86);
            this.Swordimg.Name = "Swordimg";
            this.Swordimg.Size = new System.Drawing.Size(30, 30);
            this.Swordimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Swordimg.TabIndex = 9;
            this.Swordimg.TabStop = false;
            this.Swordimg.Visible = false;
            // 
            // Playerimg
            // 
            this.Playerimg.BackColor = System.Drawing.Color.DarkGray;
            this.Playerimg.Image = global::AdventureGame.Properties.Resources.player;
            this.Playerimg.Location = new System.Drawing.Point(143, 86);
            this.Playerimg.Name = "Playerimg";
            this.Playerimg.Size = new System.Drawing.Size(30, 30);
            this.Playerimg.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Playerimg.TabIndex = 8;
            this.Playerimg.TabStop = false;
            this.Playerimg.Visible = false;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.Control;
            this.pictureBox1.Image = global::AdventureGame.Properties.Resources.dungeon600x400;
            this.pictureBox1.Location = new System.Drawing.Point(-8, 5);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(1225, 793);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // itemSord
            // 
            this.itemSord.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(223)))), ((int)(((byte)(160)))));
            this.itemSord.Image = global::AdventureGame.Properties.Resources.sword;
            this.itemSord.Location = new System.Drawing.Point(130, 636);
            this.itemSord.Name = "itemSord";
            this.itemSord.Size = new System.Drawing.Size(100, 100);
            this.itemSord.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.itemSord.TabIndex = 17;
            this.itemSord.TabStop = false;
            this.itemSord.Visible = false;
            this.itemSord.Click += new System.EventHandler(this.itemSord_Click);
            // 
            // itemBow
            // 
            this.itemBow.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(223)))), ((int)(((byte)(160)))));
            this.itemBow.Image = global::AdventureGame.Properties.Resources.bow;
            this.itemBow.Location = new System.Drawing.Point(236, 636);
            this.itemBow.Name = "itemBow";
            this.itemBow.Size = new System.Drawing.Size(100, 100);
            this.itemBow.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.itemBow.TabIndex = 18;
            this.itemBow.TabStop = false;
            this.itemBow.Visible = false;
            this.itemBow.Click += new System.EventHandler(this.itemBow_Click);
            // 
            // itemMace
            // 
            this.itemMace.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(223)))), ((int)(((byte)(160)))));
            this.itemMace.Image = global::AdventureGame.Properties.Resources.mace;
            this.itemMace.Location = new System.Drawing.Point(342, 636);
            this.itemMace.Name = "itemMace";
            this.itemMace.Size = new System.Drawing.Size(100, 100);
            this.itemMace.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.itemMace.TabIndex = 19;
            this.itemMace.TabStop = false;
            this.itemMace.Visible = false;
            this.itemMace.Click += new System.EventHandler(this.itemMace_Click);
            // 
            // itemRP
            // 
            this.itemRP.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(223)))), ((int)(((byte)(160)))));
            this.itemRP.Image = global::AdventureGame.Properties.Resources.potion_red;
            this.itemRP.Location = new System.Drawing.Point(448, 636);
            this.itemRP.Name = "itemRP";
            this.itemRP.Size = new System.Drawing.Size(100, 100);
            this.itemRP.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.itemRP.TabIndex = 20;
            this.itemRP.TabStop = false;
            this.itemRP.Visible = false;
            this.itemRP.Click += new System.EventHandler(this.itemRP_Click);
            // 
            // itemBP
            // 
            this.itemBP.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(223)))), ((int)(((byte)(160)))));
            this.itemBP.Image = global::AdventureGame.Properties.Resources.potion_blue;
            this.itemBP.Location = new System.Drawing.Point(554, 636);
            this.itemBP.Name = "itemBP";
            this.itemBP.Size = new System.Drawing.Size(100, 100);
            this.itemBP.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.itemBP.TabIndex = 21;
            this.itemBP.TabStop = false;
            this.itemBP.Visible = false;
            this.itemBP.Click += new System.EventHandler(this.itemBP_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1565, 799);
            this.Controls.Add(this.itemBP);
            this.Controls.Add(this.itemRP);
            this.Controls.Add(this.itemMace);
            this.Controls.Add(this.itemBow);
            this.Controls.Add(this.itemSord);
            this.Controls.Add(this.Playerimg);
            this.Controls.Add(this.Bowimg);
            this.Controls.Add(this.Maseimg);
            this.Controls.Add(this.Swordimg);
            this.Controls.Add(this.Redpotionimg);
            this.Controls.Add(this.Bluepotionimg);
            this.Controls.Add(this.Ghostimg);
            this.Controls.Add(this.Ghoulimg);
            this.Controls.Add(this.Batimg);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Adventure";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Redpotionimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Bluepotionimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Bowimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Maseimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Ghostimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Ghoulimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Batimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Swordimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Playerimg)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemSord)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemBow)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemMace)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemRP)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.itemBP)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button Mdown;
        private System.Windows.Forms.Button Mright;
        private System.Windows.Forms.Button Mleft;
        private System.Windows.Forms.Button Mup;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button Adown;
        private System.Windows.Forms.Button Aright;
        private System.Windows.Forms.Button Aleft;
        private System.Windows.Forms.Button Aup;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.PictureBox Playerimg;
        private System.Windows.Forms.PictureBox Swordimg;
        private System.Windows.Forms.PictureBox Batimg;
        private System.Windows.Forms.PictureBox Ghoulimg;
        private System.Windows.Forms.PictureBox Ghostimg;
        private System.Windows.Forms.PictureBox Maseimg;
        private System.Windows.Forms.PictureBox Bowimg;
        private System.Windows.Forms.PictureBox Bluepotionimg;
        private System.Windows.Forms.PictureBox Redpotionimg;
        private System.Windows.Forms.PictureBox itemSord;
        private System.Windows.Forms.PictureBox itemBow;
        private System.Windows.Forms.PictureBox itemMace;
        private System.Windows.Forms.PictureBox itemRP;
        private System.Windows.Forms.PictureBox itemBP;
        private System.Windows.Forms.Label pHP;
        private System.Windows.Forms.Label bHP;
        private System.Windows.Forms.Label GstHP;
        private System.Windows.Forms.Label oulHP;
    }
}

