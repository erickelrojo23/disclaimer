#Backend Challenge

#GitHub repository
https://github.com/erickelrojo23/disclaimer.git


#Docker Hub
docker pull erickelrojo/dockerbackchallenge


#What to do

Must create a CRUD for a Disclaimer entity
- The LIST endpoint must be able to filter the disclaimers by field “text” as an optional parameter.

GET: http://localhost:8091/disclaimers
GET: http://localhost:8091/disclaimers?text=hola

POST: http://localhost:8091/disclaimers

{
    "id":,
    "name": "",
    "text": ""
    "version": "",
    "create_at": "",
    "update_at": "" 
}


PUT: http://localhost:8091/disclaimers/{id}

{
    "name": "",
    "text": ""
    "version": "",
    "create_at": "",
    "update_at": "" 
}

DELETE: http://localhost:8091/disclaimers/{id}


Must create CREATE and LIST endpoints for the Acceptance entity
- The LIST endpoint must be able to filter the acceptances by the “user_id” field as an optional parameter

GET: http://localhost:8091/acceptances
GET: http://localhost:8091/acceptances?user_id=10





