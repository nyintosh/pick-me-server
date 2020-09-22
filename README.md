# Pick Me Server

## Spring Restful Service

### USER API End Points
```
/GET
 - getUserByUsername: /user/GET/username/{username}
 - getUserById: /user/GET/id/{id}
 - getUserByEmail: /user/GET/email/{email}
 - getAllUser: /user/GET/all

/POST
 - saveUser: /user/POST

/PUT
 - updateUserByEmail: /user/PUT/email/{email}

/DELETE
 - deleteUserByEmail: /user/DELETE/email/{email}
```

### PROJECT API End Points

```
/GET
 - getAllByLimitOrderByRandom: /project/GET/type/{type}/limit/{limit}/random/exceptId/{id}
 - getAllByLimitDescOrder: /project/GET/type/{type}/limit/{limit}/desc
 - getAllByTypeDescOrder: /project/GET/type/{type}/desc
 - getById: /project/GET/id/{id}
 - getByUserIdAndType: /project/GET/userId/{userId}/type/{type}/desc
 - getAll: /project/GET/all
 - getVoteCountByPid: /GET/vote/pid/{pid}
 - getUserVoteIdByPid: /GET/userVoteId/pid/{pid}

/POST
 - save: /project/POST
 - saveVote: /project/POST/vote

/PUT
 - updateById: /put/id/{id}

/DELETE
 - deleteById: /project/DELETE/id/{id}
 - deleteVoteByUidAndPid: /DELETE/vote/userId/{uid}/projectId/{pid}
```

### &copy; NYI HTUN