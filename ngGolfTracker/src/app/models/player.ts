//Stores entity data from db


export class Player {
    id : number | undefined;
    firstName : string | undefined;
    lastName : string | undefined;
    city : string | undefined;
    state: string | undefined;


  constructor
  (
    id : number =0,
    firstName : string = '',
    lastName : string= '',
    city : string= '',
    state: string= '',
  )
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.city = city;
    this.state= state;
  }
}
