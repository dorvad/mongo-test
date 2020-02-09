import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'post',
        loadChildren: () => import('./post/post.module').then(m => m.MongoTestPostModule)
      },
      {
        path: 'message',
        loadChildren: () => import('./message/message.module').then(m => m.MongoTestMessageModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class MongoTestEntityModule {}
