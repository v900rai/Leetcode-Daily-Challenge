class Solution {
public:
    int calPoints(vector<string>& operations) {
      stack<int> st;

      for(auto ch: operations){
        if(ch == "C") {
          st.pop();
        }
        else if( ch == "D") {
          int top = st.top();
          int newValue = top * 2;
          st.push(newValue);
        }
        else if( ch == "+") {
          int top1 = st.top();
          st.pop();
          int top2 = st.top();
          st.pop();

          int sum = top1 + top2;

          st.push(top2);
          st.push(top1);
          st.push(sum);
        }
        else {
          st.push(stoi(ch));
        }
      }

      int ans = 0;
      while(!st.empty()) {
        ans += st.top();
        st.pop();
      }

      return ans;
    }
};