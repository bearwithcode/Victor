$(document).ready(function(){
    $('#lines_of_code_cocomo1').keyup(calculateCocomo1);
    $('#lines_of_code_cocomo2').keyup(calculateCocomo2);
});

function calculateCocomo1(){
    var system_type = $('#system_type_select').val();
    var KLOC = $('#lines_of_code_cocomo1').val();

    var c = 0.0, k = 0.0;
    
    switch(system_type){
        case '1':
            c = 2.4;
            k = 1.05;
            break;
        case '2':
            c = 3.0;
            k = 1.12;
            break;
        case '3':
            c = 3.6;
            k = 1.20;
            break;
    }

    KLOC /= 1000.0;

    var output = c * Math.pow(KLOC, k);

    output = output.toFixed(2);

    output += " person-months needed for this project.";

    $('#cocomo1_output').text(output);
} 

function calculateCocomo2(){
    var scale_factor_value = getScaleFactorValues();
    var KLOC = $('#lines_of_code_cocomo2').val();
    
    var sf = 0.91 + (0.01 * scale_factor_value);

    KLOC /= 1000.0;

    var output = 2.94 * Math.pow(KLOC, sf);

    output = output.toFixed(2);

    output += " person-months needed for this project.";

    $('#cocomo2_output').text(output);
}

function getScaleFactorValues(){
    var scale_factors = [];
    var scale_factor_values = [];
    var sum = 0.0;

    scale_factor_values[0] = [6.20, 4.96, 3.72, 2.48, 1.24, 0.00];
    scale_factor_values[1] = [5.07, 4.05, 3.04, 2.03, 1.01, 0.00];
    scale_factor_values[2] = [7.07, 5.65, 4.24, 2.83, 1.41, 0.00];
    scale_factor_values[3] = [5.48, 4.38, 3.29, 2.19, 1.10, 0.00];
    scale_factor_values[4] = [7.80, 6.24, 4.68, 3.12, 1.56, 0.00];

    scale_factors[0] = parseInt($('#prec_val').val());
    scale_factors[1] = parseInt($('#flex_val').val());
    scale_factors[2] = parseInt($('#resl_val').val());
    scale_factors[3] = parseInt($('#team_val').val());
    scale_factors[4] = parseInt($('#pmat_val').val());

    for (var i = 0; i < 5; i++) {
        sum += scale_factor_values[i][scale_factors[i]];
    }

    return sum;
} 
