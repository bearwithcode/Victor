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
        {include file="header.tpl"}
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
</html>