<?php /* Smarty version Smarty-3.1.18, created on 2015-03-20 11:25:47
         compiled from ".\templates\AddMovie.tpl" */ ?>
<?php /*%%SmartyHeaderCode:280550bf5ab33d5b4-50978358%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '8f526b64b83edc09a2a29ff29b86ccd7362011dc' => 
    array (
      0 => '.\\templates\\AddMovie.tpl',
      1 => 1426846955,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '280550bf5ab33d5b4-50978358',
  'function' => 
  array (
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.18',
  'unifunc' => 'content_550bf5abb55854_61910880',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_550bf5abb55854_61910880')) {function content_550bf5abb55854_61910880($_smarty_tpl) {?><html>
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
    </head>
    <body>
        <?php echo $_smarty_tpl->getSubTemplate ("header.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, null, array(), 0);?>

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
        <script type="text/javascript" src="jquery-2.1.3.min.js"></script>
        <script type="text/javascript" src="MyScript.js"></script>      
    </body>
</html><?php }} ?>
