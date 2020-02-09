import { Moment } from 'moment';

export interface IMessage {
  id?: string;
  text?: string;
  isRead?: boolean;
  date?: Moment;
  authorLogin?: string;
  authorId?: string;
  recipientLogin?: string;
  recipientId?: string;
}

export class Message implements IMessage {
  constructor(
    public id?: string,
    public text?: string,
    public isRead?: boolean,
    public date?: Moment,
    public authorLogin?: string,
    public authorId?: string,
    public recipientLogin?: string,
    public recipientId?: string
  ) {
    this.isRead = this.isRead || false;
  }
}
