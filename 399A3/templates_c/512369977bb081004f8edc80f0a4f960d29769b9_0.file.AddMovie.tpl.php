<?php /* Smarty version 3.1.27, created on 2015-09-30 15:03:47
         compiled from "C:\coding and stuff\XAMPP\htdocs\399A3\templates\AddMovie.tpl" */ ?>
<?php
/*%%SmartyHeaderCode:13518560bddb35d0eb2_53394065%%*/
if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '512369977bb081004f8edc80f0a4f960d29769b9' => 
    array (
      0 => 'C:\\coding and stuff\\XAMPP\\htdocs\\399A3\\templates\\AddMovie.tpl',
      1 => 1429258986,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '13518560bddb35d0eb2_53394065',
  'has_nocache_code' => false,
  'version' => '3.1.27',
  'unifunc' => 'content_560bddb36078f9_00437103',
),false);
/*/%%SmartyHeaderCode%%*/
if ($_valid && !is_callable('content_560bddb36078f9_00437103')) {
function content_560bddb36078f9_00437103 ($_smarty_tpl) {

$_smarty_tpl->properties['nocache_hash'] = '13518560bddb35d0eb2_53394065';
?>
<html>
    <head>
        <meta charset="UTF-8">       
        <title>movies I like</title>
        <style>
            .targets{
                width:400px;
                height:190px;
                background-color:#aaaaaa;
            }
        </style>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0);
?>

        <form method="POST" action="AddMovie.php">
            <fieldset>
            <legend>Main record</legend>
            <label for="mvname">Movie name</label>
            <input type="text" id ="mvname" name="mvname"><br><br>
            
            <label for="mvcategory">Category</label>
            <select id="mvcategory" name="mvcategory">
                <option value="FANTASY/SCI.FI">FANTASY/SCI.FI</option>
                <option value="CHICK">CHICK</option>
                <option value="DRAMA">DRAMA</option>
                <option value="CRIME">CRIME</option>
                <option value="KIDS">KIDS</option>
                <option value="COMEDY">COMEDY</option>
                <option value="ACTION">ACTION</option>
            </select><br><br>
            
            <label for="sum">Summary</label>
            <textarea name="sum" id="sum" rows="7" cols="20"></textarea>
        </fieldset>
        
        <fieldset>
            <legend>Supplementary data</legend>
            <input type="button" value="Add data" id="add"><br><br>
            <table border="3" id="Mymovie">
                <tr>
                    <th>Picture</th>
                    <th>Command</th>
                </tr>
            </table>
        </fieldset>
        
        <fieldset>
            <legend>Action</legend>
            <input type="submit" value="Create Record">
        </fieldset>
        </form>  
        <?php echo '<script'; ?>
 type="text/javascript" src="jquery-2.1.3.min.js"><?php echo '</script'; ?>
>
        <?php echo '<script'; ?>
 type="text/javascript" src="MyScript.js"><?php echo '</script'; ?>
>      
    </body>
</html><?php }
}
?>