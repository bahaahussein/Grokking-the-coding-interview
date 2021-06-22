package com.two.heaps;

import java.util.PriorityQueue;

public class MaximizeCapital {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((x, y) -> Integer.compare(y.profit, x.profit));
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((x, y) -> Integer.compare(x.capital, y.capital));
        int N = profits.length;
        for(int i=0; i<N; i++) {
            if(w>=capital[i])
                maxProfitHeap.add(new Project(profits[i], capital[i]));
            else
                minCapitalHeap.add(new Project(profits[i], capital[i]));
        }
        for(int i=0; i<k; i++) {
            if(maxProfitHeap.isEmpty())
                return w;
            w += maxProfitHeap.remove().profit;
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital<=w)
                maxProfitHeap.add(minCapitalHeap.remove());
        }
        return w;
    }
}

class Project {

    int profit;

    int capital;

    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}
