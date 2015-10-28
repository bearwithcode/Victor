<?php /* Smarty version Smarty-3.1.18, created on 2015-04-17 08:27:00
         compiled from "C:\xampp\htdocs\399A3\templates\AddReport.tpl" */ ?>
<?php /*%%SmartyHeaderCode:20300550bf62b2735b0-30802534%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    'd8d894c2fbea2f5fec0c7102b3a2685752d1bcfa' => 
    array (
      0 => 'C:\\xampp\\htdocs\\399A3\\templates\\AddReport.tpl',
      1 => 1429251828,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '20300550bf62b2735b0-30802534',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550bf62b35b0d7_25094670',
  'variables' => 
  array (
    'headt' => 0,
    'mname' => 0,
    'mnum' => 0,
    'picnum' => 0,
  ),
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550bf62b35b0d7_25094670')) {function content_550bf62b35b0d7_25094670($_smarty_tpl) {?><html>
    <head>
        <meta charset="UTF-8">
        <title>success</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, null, array(), 0);?>

        <h1><?php echo $_smarty_tpl->tpl_vars['headt']->value;?>
</h1>
        <p>created a record for <?php echo $_smarty_tpl->tpl_vars['mname']->value;?>
 (it is reacord#<?php echo $_smarty_tpl->tpl_vars['mnum']->value;?>
) with <?php echo $_smarty_tpl->tpl_vars['picnum']->value;?>
 photo</p>
        <a href="AddMovie.php">Create another</a>
    </body>
</html><?php }} ?>
