import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.sass']
})
export class TemplateComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  isSelectedMenu(url: string): boolean {
    return this.router.isActive(this.router.parseUrl(url), true);
  }
}
