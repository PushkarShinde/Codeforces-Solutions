#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin>>t;
    vector<int>d;
    int t1=t;
    while(t--){
        int l,b,h,s;
        cin>> l>>b>>h>>s;
        d.push_back(l);
        d.push_back(b);
        d.push_back(h);
        d.push_back(s);
    }
    for(size_t i=0;i<=(t1-1)*4;i+=4){
        if(d[i]*d[i+1]*d[i+2]<d[i+3]*d[i+3]*d[i+3]){
            cout << "CUBOID\n"; 
        } else if(d[i]*d[i+1]*d[i+2]>d[i+3]*d[i+3]*d[i+3]){
            cout << "CUBE\n";
        } else{
            cout << "EQUAL\n";
        }
    }
    return 0;
}