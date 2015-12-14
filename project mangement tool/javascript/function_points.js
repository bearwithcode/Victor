$(document).ready(function(){
    $('.fp_input').change(calculateFunctionPoints);
});

function calculateFunctionPoints(){
    var complexity_multiplier = getComplexityMultipliers();
    var tdi = getTDI();

    var vaf = 0.65 + (0.01 * tdi);

    var fp = complexity_multiplier * vaf;

    fp = fp.toFixed(2);

    $('#function_points_output').text(fp + " function points");
}

function getComplexityMultipliers(){
    var sum = 0;
    var complexity_multipliers = [];
    var function_types = [];

    complexity_multipliers[0] = [3, 4, 6];
    complexity_multipliers[1] = [4, 5, 7];
    complexity_multipliers[2] = [3, 4, 6];
    complexity_multipliers[3] = [7, 10, 15];
    complexity_multipliers[4] = [5, 7, 10];
    
    function_types[0] = parseInt($('#ilf_val').val());
    function_types[1] = parseInt($('#eif_val').val());
    function_types[2] = parseInt($('#ei_val').val());
    function_types[3] = parseInt($('#eo_val').val());
    function_types[4] = parseInt($('#eq_val').val());

    for (var i = 0; i < 5; i++) {
        sum += complexity_multipliers[i][function_types[i]];
    }

    return sum;
}

function getTDI () {
    var sum = 0;

    sum += parseInt($('#data_comm_val').val());
    sum += parseInt($('#dist_data_val').val());
    sum += parseInt($('#perform_val').val());
    sum += parseInt($('#heavy_use_val').val());
    sum += parseInt($('#trans_rate_val').val());
    sum += parseInt($('#online_data_val').val());
    sum += parseInt($('#end_user_val').val());
    sum += parseInt($('#online_update_val').val());
    sum += parseInt($('#complex_proc_val').val());
    sum += parseInt($('#reuse_val').val());
    sum += parseInt($('#install_ease_val').val());
    sum += parseInt($('#oper_ease_val').val());
    sum += parseInt($('#multiple_sites_val').val());
    sum += parseInt($('#fac_change_val').val());

    return sum;
}