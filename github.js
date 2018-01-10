angular.module('githubService',[])
    .factory('github',['$http',function ($http) {
        var baseUrl = "https://api.github.com/";
        var subUrl_1 = "users/";

        var getUser = function (username) {
            return $http.get(baseUrl + subUrl_1 + username).then(function (response) {
                return response.data;
            });
        };

        var getRepos = function (user) {
            return $http.get(user.repos_url).then(function (response) {
                return response.data;
            });
        };

        return {
            getUser:getUser,
            getRepos:getRepos
        }
}]);