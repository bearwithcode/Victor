<?php /* Smarty version Smarty-3.1.18, created on 2015-04-20 14:07:02
         compiled from "C:\xampp\htdocs\399A3\templates\SearchReport.tpl" */ ?>
<?php /*%%SmartyHeaderCode:185550c0d7aaa5a82-93920846%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '9a1819377b3c212d3c5674751a2db678731c7946' => 
    array (
      0 => 'C:\\xampp\\htdocs\\399A3\\templates\\SearchReport.tpl',
      1 => 1429251828,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '185550c0d7aaa5a82-93920846',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550c0d7b029f38_76203065',
  'variables' => 
  array (
    'cat' => 0,
    'mvks' => 0,
    'mvk' => 0,
  ),
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550c0d7b029f38_76203065')) {function content_550c0d7b029f38_76203065($_smarty_tpl) {?><html>
    <head>
        <meta charset="UTF-8">
        <title>success</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, null, array(), 0);?>

        <h1>Search movie library by category <?php echo $_smarty_tpl->tpl_vars['cat']->value;?>
</h1>
        <table border="3">
            <th>Movie</th>
            <?php  $_smarty_tpl->tpl_vars['mvk'] = new Smarty_Variable; $_smarty_tpl->tpl_vars['mvk']->_loop = false;
 $_from = $_smarty_tpl->tpl_vars['mvks']->value; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array');}
foreach ($_from as $_smarty_tpl->tpl_vars['mvk']->key => $_smarty_tpl->tpl_vars['mvk']->value) {
$_smarty_tpl->tpl_vars['mvk']->_loop = true;
?>
            <tr>
                <td>
                    <a href='SearchResult.php?mvn=<?php echo $_smarty_tpl->tpl_vars['mvk']->value;?>
'><?php echo $_smarty_tpl->tpl_vars['mvk']->value;?>
</a>
                </td>
            </tr>
            <?php } ?>
        </table>                
    </body>
</html><?php }} ?>
