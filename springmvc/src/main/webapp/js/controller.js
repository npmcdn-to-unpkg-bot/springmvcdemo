function PhoneListCtrl($scope) {
    $scope.phones = [
        {
            "name": "Nexus S",
            "snippet": "Fast just got faster with Nexus S.",
            "age": 0
        },
        {
            "name": "Motorola XO with Wi-Fi",
            "snippet": "The Next, Next Generation tablet.",
            "age": 1
        },
        {
            "name": "MOTOROLA",
            "snippet": "The Next, Next Generation tablet.",
            "age": 2
        }
    ];
}

angular.module('app', []).controller('PhoneList', PhoneListCtrl);