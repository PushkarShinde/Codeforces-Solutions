#include <bits/stdc++.h>
using namespace std;

string convertBinary(int n) {
    string bin ="";
    while (n) {
        bin+=(n%2)?'1':'0';
        n/=2;
    }
    reverse(bin.begin(),bin.end()); 
    return bin;
}

long long sum(vector<int>& ar) {
    long long total=0;
    for (int num : ar) {
        total+=num;
    }
    return total;
}

int solve(vector<int> a,int n,int q) {
    vector<int> res = a;
    long long initial_sum = sum(res); 
    while (q--) {
        // Juliet
        sort(a.begin(),a.end(),greater<int>()); 
        bool key = false;
        string bin = convertBinary(a[0]);
        int j;
        for(j = 0; j < bin.length(); j++) {
            if(bin[j] == '0') {
                bin[j] = '1';
                key = true;
                break;
            }
        }
        a[0]+=(1LL << (bin.length() -j -1)); 

        // Romeo 
        sort(a.begin(), a.end());
        key= false;
        bin= convertBinary(a[0]);
        for(j = bin.length() - 1; j >= 0; j--) {
            if (bin[j] == '1') {
                bin[j] = '0';
                key = true;
                break;
            }
        }
        a[0]-= (1LL<<(bin.length() - j - 1));
    }
    long long final_sum= sum(a);
    return(final_sum > initial_sum) ? final_sum : -1;
}

int main() {
    int t;
    cin >> t;
    vector<long long>results;
    while(t--){
        int n, q;
        cin >> n >> q;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        results.push_back(solve(arr, n, q));
    }
    for(long long res:results) {
        cout << res << '\n';
    }
    return 0;
}