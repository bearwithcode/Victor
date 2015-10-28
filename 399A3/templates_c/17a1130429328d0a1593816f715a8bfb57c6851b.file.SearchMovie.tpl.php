<?php /* Smarty version Smarty-3.1.18, created on 2015-04-17 08:24:00
         compiled from "C:\xampp\htdocs\399A3\templates\SearchMovie.tpl" */ ?>
<?php /*%%SmartyHeaderCode:3430550c0d73242cb3-94588093%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '17a1130429328d0a1593816f715a8bfb57c6851b' => 
    array (
      0 => 'C:\\xampp\\htdocs\\399A3\\templates\\SearchMovie.tpl',
      1 => 1429251828,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '3430550c0d73242cb3-94588093',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550c0d735a8286_87771440',
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550c0d735a8286_87771440')) {function content_550c0d735a8286_87771440($_smarty_tpl) {?><html>
    <head>
        <meta charset="UTF-8">
        <title>Search for movie</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, null, array(), 0);?>

        <form method="post" action="SearchMovie.php">
            <fieldset>
                <select name="mvcategory">
                    <option value="FANTASY/SCI.FI">FANTASY/SCI.FI</option>
                    <option value="CHICK">CHICK</option>
                    <option value="DRAMA">DRAMA</option>
                    <option value="CRIME">CRIME</option>
                    <option value="KIDS">KIDS</option>
                    <option value="COMEDY">COMEDY</option>
                    <option value="ACTION">ACTION</option>
                </select><br><br>
            </fieldset>
            <fieldset>
                <legend>Action</legend>
                <input type="submit" value="Search Records">
            </fieldset>
        </form>
    </body>
</html><?php }} ?>
