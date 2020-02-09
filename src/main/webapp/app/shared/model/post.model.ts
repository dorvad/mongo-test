export interface IPost {
  id?: string;
  title?: string;
  text?: string;
  authorLogin?: string;
  authorId?: string;
}

export class Post implements IPost {
  constructor(public id?: string, public title?: string, public text?: string, public authorLogin?: string, public authorId?: string) {}
}
