#include <bits/stdc++.h>
using namespace std;

vector<int> solve(vector<string>&sing){
    vector<int>repeat;
    for(auto &s:sing){
        int count=0;
        int temp=0;
        for(int i=1;i<s.length();i++){
            if(s[i]==s[i-1]){
                ++count;
            }else{
                temp++;
            }
        }
        if(count){
            repeat.push_back(s.length()-count-temp);
        }else{
            repeat.push_back(s.length());
        }
    }
    return repeat;
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
    vector<int>min=solve(sing);
    for(auto i:min){
        cout << i << endl;
    }
    return 0;
}