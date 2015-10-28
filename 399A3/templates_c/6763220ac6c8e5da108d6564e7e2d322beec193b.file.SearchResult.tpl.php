<?php /* Smarty version Smarty-3.1.18, created on 2015-04-20 14:08:09
         compiled from "C:\xampp\htdocs\399A3\templates\SearchResult.tpl" */ ?>
<?php /*%%SmartyHeaderCode:18235550c0eb7a2da77-10996878%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '6763220ac6c8e5da108d6564e7e2d322beec193b' => 
    array (
      0 => 'C:\\xampp\\htdocs\\399A3\\templates\\SearchResult.tpl',
      1 => 1429251829,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '18235550c0eb7a2da77-10996878',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550c0eb7cf5840_37692893',
  'variables' => 
  array (
    'name' => 0,
    'cat' => 0,
    'info' => 0,
    'num' => 0,
    'i' => 0,
    'pics' => 0,
    'comms' => 0,
  ),
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550c0eb7cf5840_37692893')) {function content_550c0eb7cf5840_37692893($_smarty_tpl) {?><html>
    <head>
        <meta charset="UTF-8">
        <title>Search for movie</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, null, array(), 0);?>

        <h1><?php echo $_smarty_tpl->tpl_vars['name']->value;?>
</h1>
        <h2><?php echo $_smarty_tpl->tpl_vars['cat']->value;?>
</h2><br>
        <h3>INFO</h3>
        <p><?php echo $_smarty_tpl->tpl_vars['info']->value;?>
</p><br>
        <h3>Supplementary data</h3><br>
        
        <?php $_smarty_tpl->tpl_vars['i'] = new Smarty_Variable;$_smarty_tpl->tpl_vars['i']->step = 1;$_smarty_tpl->tpl_vars['i']->total = (int) ceil(($_smarty_tpl->tpl_vars['i']->step > 0 ? $_smarty_tpl->tpl_vars['num']->value+1 - (0) : 0-($_smarty_tpl->tpl_vars['num']->value)+1)/abs($_smarty_tpl->tpl_vars['i']->step));
if ($_smarty_tpl->tpl_vars['i']->total > 0) {
for ($_smarty_tpl->tpl_vars['i']->value = 0, $_smarty_tpl->tpl_vars['i']->iteration = 1;$_smarty_tpl->tpl_vars['i']->iteration <= $_smarty_tpl->tpl_vars['i']->total;$_smarty_tpl->tpl_vars['i']->value += $_smarty_tpl->tpl_vars['i']->step, $_smarty_tpl->tpl_vars['i']->iteration++) {
$_smarty_tpl->tpl_vars['i']->first = $_smarty_tpl->tpl_vars['i']->iteration == 1;$_smarty_tpl->tpl_vars['i']->last = $_smarty_tpl->tpl_vars['i']->iteration == $_smarty_tpl->tpl_vars['i']->total;?>
            <img src='<?php echo $_smarty_tpl->tpl_vars['pics']->value[$_smarty_tpl->tpl_vars['i']->value];?>
'><br>
            <p><?php echo $_smarty_tpl->tpl_vars['comms']->value[$_smarty_tpl->tpl_vars['i']->value];?>
</p>
            <hr>
        <?php }} ?>
    </body>
</html><?php }} ?>
