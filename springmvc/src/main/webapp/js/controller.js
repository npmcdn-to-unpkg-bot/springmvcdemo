function PhoneListCtrl($scope) {
    $scope.phones = [
        {
            "name": "Nexus S",
            "snippet": "Fast just got faster with Nexus S."
        },
        {
            "name": "Motorola XO with Wi-Fi",
            "snippet": "The Next, Next Generation tablet."
        },
        {
            "name": "MOTOROLA",
            "snippet": "The Next, Next Generation tablet."
        }
    ];
}
angular.module('app', []).controller('PhoneListCtrl', PhoneListCtrl);