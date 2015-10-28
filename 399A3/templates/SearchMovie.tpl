<html>
    <head>
        <meta charset="UTF-8">
        <title>Search for movie</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        {include file="header.tpl"}
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
</html>