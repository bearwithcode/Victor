<?php /* Smarty version Smarty-3.1.18, created on 2015-03-20 11:05:26
         compiled from "C:\xampp\htdocs\399A3\templates\error.tpl" */ ?>
<?php /*%%SmartyHeaderCode:13470550bf0e6a403f2-83426192%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    'ca7d5f0f48dfe29214d4e995a398675566ed666e' => 
    array (
      0 => 'C:\\xampp\\htdocs\\399A3\\templates\\error.tpl',
      1 => 1426839676,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '13470550bf0e6a403f2-83426192',
  'function' => 
  array (
  ),
  'variables' => 
  array (
    'error' => 0,
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550bf0e6b5c2a6_71202070',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550bf0e6b5c2a6_71202070')) {function content_550bf0e6b5c2a6_71202070($_smarty_tpl) {?><html>
    <head>
        <meta charset="UTF-8">
        <title>error</title>
    </head>
    <body>
        <h1><?php echo $_smarty_tpl->tpl_vars['error']->value;?>
</h1>    
        <a href="../welcomeAdd.php">Create another</a>
    </body>
</html><?php }} ?>
