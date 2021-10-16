# Free Vector <img src="https://github.com/ylc-tom/free_vector/blob/main/img/free_vector_logo.png" width="40px" />
A vector based database &amp; search engine.

---
## Commit Notes
* 2021.10.16 Repo creation - Free Vector birthday

---
## Design Doc
* Keywords
  + A distributed platform (also works for single machine which is a typical use case under distributed platform)
  + Event stream pattern for insertion & search
  + 
* Architecture Diagram
  ```
  [User]
    |
    |---------------|
    v               |
  [SDK]-------------|
                    |
                    v
                 [HTTP]
                    |
    --------------------------------
    |               |              |
    v               v              v
  [agent]        [agent]        [agent]
  
  
  
  
  
  [kvStore]      [kvStore]      [kvStore]               [idxStore] 
  
  ```
