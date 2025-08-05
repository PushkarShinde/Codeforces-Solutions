#include <bits/stdc++.h>
using namespace std;

char solve(int k){
    string core="a";
    while (core.length()<k){
        string evolve="";
        for(char c:core){
            if(c=='z'){
                evolve+='a';
            }else{
                evolve+=c+1;
            }
        }
        core+=evolve;
    }
    return core[k-1];
}

int main() {
    // int t;
    // cin>>t;
    // vector<int>tc(t);
    // for(int i=0;i<t;i++){
    //     cin >>tc[i];
    // }
    // vector<char>results;
    // for(int k:tc){
    //     results.push_back(solve(k));
    // }
    // for(char res:results){
    //     cout <<res<<endl;
    // }

    int t;
    cin>>t;
    cout << solve(t);
    return 0;
}