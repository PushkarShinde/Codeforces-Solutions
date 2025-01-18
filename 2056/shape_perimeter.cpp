#include <bits/stdc++.h>
using namespace std;

long solve(int op, int sl, vector<pair<int, int>>&cods){
    int rt=sl,up=sl, i=0;

    for(int i=0;i<op;i++){
        rt+=cods[i].first; 
        up+=cods[i].second;
    }
    rt-=cods[0].first;
    up-=cods[0].second;
    return 2*(rt+up);
}

int main() {
    int t;
    cin>>t;
    while(t--){
        int op;
        int sl; 
        cin>>op>>sl;
        vector<pair<int, int>>cods(op);
        for(int i=0;i<op;i++){
            cin>>cods[i].first>>cods[i].second;
        }
        cout << solve(op,sl,cods)<< endl;
    }
    return 0;
}