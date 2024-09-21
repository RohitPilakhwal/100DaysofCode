class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(String.valueOf(i));
        }
        Collections.sort(list);
        List<Integer> listint = new ArrayList<>();
        for(int i=0;i<n;i++){
            listint.add(Integer.valueOf(list.get(i)));
        }
        return listint;
        
    }
}