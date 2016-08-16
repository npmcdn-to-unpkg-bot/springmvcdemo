/**
 * Created by kimi on 8/16/16.
 */

var app =
    angular.module('app', []);

function listController($scope, $http) {
    var url = "/springmvc/showcase/query3";
    $http.get(url).success(function (response) {
        $scope.projects = response.result;
        console.log(response.result);
    });
}

function addController($scope, $http) {
    var url = "/springmvc/showcase/add2";

    $scope.departmentId = null;
    $scope.departmentName = '';

    $scope.add = function () {
        $http(
            {
                method: "POST",
                url: url,
                data: {
                    'departmentId': $scope.departmentId,
                    'departmentName': $scope.departmentName
                }
            }
        ).success(function (response) {
            $scope.result = response;
            console.log(response);
        });
    }
}
app.controller('ProjectListController', listController).controller('AddProjectController', addController);