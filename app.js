var app = angular.module('myApp',['ngRoute','githubService']);//the thing is you have to put these in here, study later

app.config(function ($routeProvider) {
    $routeProvider
        .when("/main",{
            templateUrl:"main.html",
            controller:"MainController"
        })
        .when("/user/:username",{
            templateUrl:"user_detail.html",
            controller:"UserController"
        })//it will treat this as a parameter
        .when("/repo/:projectname/:reponame",{
            templateUrl:"repository_detail.html",
            controller:"RepositoryController"
        })
        .otherwise({redirectTo:"/main"});
});
