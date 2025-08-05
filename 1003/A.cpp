#include <bits/stdc++.h>
using namespace std;

void solve(vector<string>&sing){
    int n=sing.size();
    for(auto &s:sing){
        s.pop_back();
        s.pop_back();
        s.push_back('i');
    }
}

int main() {
    int t;
    cin>>t;
    vector<string>sing;
    while(t--){
        string str;
        cin>>str;
        sing.push_back(str);
    }
    solve(sing);
    for(auto str:sing){
        cout << str << endl;
    }
    return 0;
}