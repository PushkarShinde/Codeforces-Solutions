#include <bits/stdc++.h>
using namespace std;


int main() {
    int n;
    cin>>n;
    vector<vector<long>>station(3,vector<long>(n));
    for(int i=0;i<3;i++){
        for(int j=0;j<n;j++){
            cin>>station[i][j];
        }
    }
    

    return 0;
}