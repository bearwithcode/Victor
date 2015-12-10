/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colourmap = ["#ff0000", "#ffff00", "#0000ff", "#00ff00", "#00ffff", "#ff00ff", "#800000", "#008000", "#000080"];

var colcount = 0;
var checkbox = [-1, -1, -1];

var app = angular.module("myResumeApp", []);
app.controller("myResumeCon", function ($scope) {
    var experience = [
        {years: 3, name: "HTML5,javascript"},
        {years: 2, name: "java and java servlet technology"},
        {years: 2, name: "framework for PHP like Zend Framework and Smarty"},
        {years: 2, name: "CSS framework like Bootstrap"},
        {years: 2, name: "ORM system like(Hibernate JPA, ADOdb, PDO)"},
        {years: 1, name: "xml and json"},
        {years: 1, name: "framework for JavaScript Angular.js and jQuery-mobile"},
        {years: 1, name: "responsive web page design"},
        {years: 1, name: "CMS like WordPress"},
        {years: 0.5, name: "python"}
    ];
    
    $scope.allexp = experience;
    $scope.sortCol = "name";
    $scope.reverseSort = false;
    
    $scope.sortData = function(col){
        $scope.reverseSort = ($scope.sortCol === col) ? !$scope.reverseSort : false;
        $scope.sortCol = col;
    };
    
    $scope.getSortClass = function(col){
        if($scope.sortCol === col){
            return $scope.reverseSort ? "arrow-down":"arrow-up";
        }
        else
            return '';
    };
    
});

$(document).ready(function () {
    $('#welcome').fadeIn(2000);
    $('#meinfo').slideDown(2500);

    setInterval(changebuttoncol, 500);
    setInterval(highlightinletter, 2000);
    setInterval(beating, 1000);
    $('#projectbu').hide();
});

function changebuttoncol() {
    $("#butt").css("color", colourmap[colcount]);
    colcount++;
    if (colcount === colourmap.length - 1) {
        colcount = 0;
    }
}

function highlightinletter() {
    $('.hl').toggleClass('highlight');
}

function beating() {
    $('#heart').toggleClass('heart-beating');
}

function checkall(boxvalue) {
    checkbox[boxvalue - 1] *= -1;
    var pid = "p" + boxvalue;

    $("#" + pid).fadeToggle();

    var find = false;

    for (var i = 0; i < checkbox.length; i++) {
        if (checkbox[i] == -1) {
            find = true;
        }
    }


    if (find == false) {
        alert("you have unlock project button on top-right side");
        $('#projectbu').show();
    } else {
        $('#projectbu').hide();
    }
}


