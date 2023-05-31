import { Client } from './client';

export class Compte {
  constructor(
    public login?: string,
    public role?: string,
    public client?: Client
  ) {}
}
