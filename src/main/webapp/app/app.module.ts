import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { MongoTestSharedModule } from 'app/shared/shared.module';
import { MongoTestCoreModule } from 'app/core/core.module';
import { MongoTestAppRoutingModule } from './app-routing.module';
import { MongoTestHomeModule } from './home/home.module';
import { MongoTestEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    MongoTestSharedModule,
    MongoTestCoreModule,
    MongoTestHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    MongoTestEntityModule,
    MongoTestAppRoutingModule
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [JhiMainComponent]
})
export class MongoTestAppModule {}
