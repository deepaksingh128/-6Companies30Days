        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of array elements
        
        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than arr[i]
            // These values cannot be the maximum for the current or future windows
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offerLast(i);

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        
        return result;
